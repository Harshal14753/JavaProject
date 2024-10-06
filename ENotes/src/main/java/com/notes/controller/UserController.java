package com.notes.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notes.entity.Notes;
import com.notes.entity.User;
import com.notes.repository.UserRepo;
import com.notes.service.NotesServicesImpl;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private NotesServicesImpl notesService;

	@ModelAttribute
	public User getUser(Principal p, Model model) {
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		model.addAttribute("user", user);
		return user;
	}

	@GetMapping("/home")
	public String home() {
		return "index";
	}

	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}

	@GetMapping("/addNotes")
	public String addNotes() {
		return "addNotes";
	}

	@GetMapping("/viewNotes")
	public String viewNotes(Model m, Principal p) {
		User user = getUser(p, m);
		List<Notes> notesList = notesService.getNotesByUser(user);
		m.addAttribute("notesList", notesList);
		return "viewNotes";
	}

	@GetMapping("/editNotes/{id}")
	public String editNotes(@PathVariable int id, Model m) {
		Notes notes = notesService.getNotesById(id);
		m.addAttribute("n", notes);
		return "editNotes";
	}

	@PostMapping("/saveNotes")
	public String saveNotes(@ModelAttribute Notes notes, HttpSession session, Principal p, Model m) {
		notes.setDate(LocalDate.now());
		notes.setUser(getUser(p, m));
		Notes saveNotes = notesService.saveNotes(notes);
		if (saveNotes != null) {
			session.setAttribute("msg1", "Notes added Succesfully");
		} else {
			session.setAttribute("msg2", "Something error");
		}
		return "redirect:/user/addNotes";
	}

	@PostMapping("/updateNotes")
	public String updateNotes(@ModelAttribute Notes notes, HttpSession session, Principal p, Model m) {
		notes.setDate(LocalDate.now());
		notes.setUser(getUser(p, m));
		Notes saveNotes = notesService.saveNotes(notes);
		if (saveNotes != null) {
			session.setAttribute("msg1", "Notes update Succesfully");
		} else {
			session.setAttribute("msg2", "Something error");
		}
		return "redirect:/user/viewNotes";
	}

	@GetMapping("/deleteNotes/{id}")
	public String deleteNotes(@PathVariable int id, HttpSession session) {
		boolean isDelete = notesService.deleteNotes(id);

		if (isDelete) {
			session.setAttribute("msg3", "Notes deleted Succesfully");
		} else {
			session.setAttribute("msg4", "Something error");
		}
		return "redirect:/user/viewNotes";
	}

}

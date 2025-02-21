# History
Java is an Object-Oriented programming language developed by James Gosling in the early 1991.
The language was originally called Oak, but was later renamed to Java
<br/>
<br/>

# Datatypes 
## 1. Primitive Datatypes
Primitive data types are the building blocks of data manipulation.

> [!NOTE]
> No. of Primitive data types : 8


## 2. Non-Primitive Datatypes
Non-primitive data types are the complex data types that are used to store multiple values.
<br/>
Ex :- Arrays, ArrayList, HashMap, Class, Interface etc.

![Alt text](datatypes.png)
<br/>
![Alt text](datatype_size.png)


> [!NOTE]
> Automatic type conversion is possible in which of the cases <br/>
> -> int to long

It will be understand by Ex : 
```
public class Solution{
    public static void main(String[] args){
        short x = 10;
        x =  x * 5;
        System.out.print(x);
    }
}
```

## Integer and Float

## Q1
![Alt text](Q1.png)
 
Answer :- 
Explanation: Statements (1), (2), (3), and (4) are correct. (1) is correct because when a floating-point number (a double in this case) is cast to an int, it simply loses the digits after the decimal. (2) and (4) are correct because a long can be cast into a byte. If the long is over 127, it loses its precision due to narrowing of the conversion. (3) actually works, even though a cast is not necessary, because a long can store a byte.


> An expression involving byte, int, and literal numbers is promoted to which of these? <br>
Answer :- int

> Which data type value is returned by all transcendental math functions? <br/>
> Answer :- double

<br>
What is output

```
class output {
        public static void main(String args[]) 
        {
            double a, b,c; 
            a = 3.0/0;   -> Infinity
            b = 0/4.0;   -> 0.0
            c=0/0.0;     -> NaN
 
	        System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        } 
    }
```

## Character and Boolean

> Which of these coding types is used for data type characters in Java? <br>
Answer :- UNICODE

```
3. Which of these values can a boolean variable contain?
a) True & False
b) 0 & 1
c) Any integer value
d) true

Ans :- true
```

```
Which one is a valid declaration of a boolean?
a) boolean b1 = 1;
b) boolean b2 = ‘false’;
c) boolean b3 = false;
d) boolean b4 = ‘true’
Ans :- c
```

The **ASCII** (American Standard Code for Information Interchange) values for uppercase letters A to Z range from 65 to 90, and the values for lowercase letters a to z range from 97 to 122.

## '&' (bitwise AND operator) <br>
-> It compares each bit of the first operand to the corresponding bit of the second operand. <br>
-> It returns true when both the values are true and false otherwise. Since, var1 is defined true and var2 is defined false hence their ‘&’ operator result is false.


## Enum
Enums are used to define a set of named constants, providing a way to represent a fixed set of values.

```
Can we create an instance of Enum outside of Enum itself?
a) True
b) False
Ans :- False
```

```
 enum Season 
    {
        WINTER, SPRING, SUMMER, FALL
    };
    System.out.println(Season.WINTER.ordinal()); -> 0
```

```
class A
{
 
}
 
enum Enums extends A
{
    ABC, BCD, CDE, DEF;
}

a) Runtime Error
b) Compilation Error
c) It runs successfully
d) EnumNotDefined Exception

Ans :- b (syntax error)
```

> [!TIP]
>Enum cannot have any modifiers. They are public, static and final by default.

> [!TIP]
> Syntax wrong means compilation error 

```
enum Enums
{
    A, B, C;
 
    private Enums()
    {
        System.out.println(10);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        Enum en = Enums.B;
    }
}

Ans :- 10 10 10
```

## BigDecimal

**getEnumConstants()** returns the elements of this enum class or null if this Class object does not represent an enum type.

BigDecimal has unnatural syntax, needs more memory and creates a great amount of garbage. But it has a high precision which is useful for some calculations like money.

```
double a = 0.02;
   double b = 0.03;
   double c = b - a;
   System.out.println(c);
 
   BigDecimal _a = new BigDecimal("0.02");
   BigDecimal _b = new BigDecimal("0.03");
   BigDecimal _c = b.subtract(_a);
   System.out.println(_c);

   Ans :-   0.009999999999999998
            0.01
```

BigDecimal provides more precision as compared to double. Double is faster in terms of performance as compared to BigDecimal.

## Date and TimeZone

> [!NOTE]
> sdf.parse converts the String to Date object.
> sdf.format converts the Date object to String.

How to format date from one form to another?
```
Date now = new Date();
SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-mm-dd'T'hh:MM:ss");
String nowStr = sdf.format(now);         -> date to String
System.out.println("Current Date: " + );
```

How to convert a String to a Date object?
```
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
sdf.parse(new Date());
```

SimpleDateFormat is not thread safe. In the multithreaded environment, we need to manage threads explicitly.<br>
Java.sql.Date is the datatype of Date stored in database.

How to get difference between two dates?
> long diffInMilli = java.time.Duration.between(dateTime1, dateTime2).toMillis();

How to get UTC time?
> Instant.now();

## Literals & Variables
**Literals** in Java is a synthetic representation of boolean, numeric, character, or string data. 

```
Which of these is long data type literal?
a) 0x99fffL
b) ABCDEFG
c) 0x99fffa
d) 99671246

Answer: a
Explanation: Data type long literals are appended by an upper or lowercase L. 0x99fffL is hexadecimal long literal.
```

```
Which of these can be returned by the operator &?
a) Integer
b) Boolean
c) Character
d) Integer or Boolean

Answer: d
Explanation: We can use binary ampersand operator on integers/chars (and it returns an integer) or on booleans (and it returns a boolean).
```

```
 Which of these can not be used for a variable name in Java?
a) identifier
b) keyword
c) identifier & keyword
d) none of the mentioned

Answer: b
Explanation: Keywords are specially reserved words which can not be used for naming a user defined variable, example: class, int, for etc.
```

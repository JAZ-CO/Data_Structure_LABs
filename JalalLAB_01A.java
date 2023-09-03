// Name, ID, Section Number, Date
// Jalal Zainaddin, s202154790, 54, 09/03/2023
public class JalalLAB_01A{
    public static void main(String[] args) {
        //Book Practice question
        //Create an array of 10 books
        Book[] books = new Book[7];
        books[0] = new Book("ABC",100);
        books[1] = new Book("Arabic",100);
        books[2] = new TextBook("Data Structures" ,"ICS-202",200);
        books[3] = new TextBook("Writing Practice","ENGL-101",300);
        books[4] = new TextBook("Algebra","MATH-101", 500);
        books[5] = new Book("Water Conservation",200);
        books[6] = new TextBook("Introduction to Technology","TECH-102",500);

        // create a variable to count a number of Books of type "TextBook"
        int numTextBooks= 0;
        // print each element
        for (int i = 0; i < books.length; i++) {
            if (books[i] instanceof TextBook)
                numTextBooks++;
            System.out.println(books[i]);
        }
        // Print the number of Each book
        System.out.println("Number of Books = " + (books.length - numTextBooks));
        System.out.println("Number of TextBooks = " + numTextBooks);

    }
}

//Book classes
class Book{
    private String title;
    private int pages;

    Book(String title, int pages){
        this.title = title;
        this.pages = pages;
    }
    // Getters of title and pages

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }
    // Overriding toString from the Object class

    @Override
    public String toString() {
        return "Book: " + this.getTitle() + ", # Pages = " + this.getPages();
    }
}
class TextBook extends Book{
    private String course;
    TextBook(String title, String course, int pages){
        super(title,pages);
        this.course = course;
    }
    // getter for course variable

    public String getCourse() {
        return course;
    }

    // Overriding toString from Book class
    @Override
    public String toString() {
        return "Text Book: " + this.getTitle() + ", " + this.getCourse()+", # Pages = " + this.getPages() +
                ", Course = " +this.getCourse();
    }

}


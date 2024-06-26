package dplibraryproject;

/**
 * 
 */
public class Book {
    private String title;
    private String author;
    private String isbn;

    private Book(BookBuilder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.isbn = builder.isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", isbn='" + isbn + '\'' +
               '}';
    }

    // Static Builder Class
    public static class BookBuilder {
        private String title;
        private String author;
        private String isbn;

        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
    
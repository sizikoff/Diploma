package com.example.diploma.news;

public class News {

        String title;
        int author;
        String descript;
        String date;
        String section;

    public News(String descript, int author,String section) {
        this.author = author;
        this.descript = descript;
        this.section = section;
    }

        public String getTitle() {
        return title;
    }

        public void setTitle(String title) {
        this.title = title;
    }

        public int getAuthor() {
        return author;
    }


        public String getUrl() {
        return descript;
    }

        public void setUrl(String url) {
        this.descript = url;
    }

        public String getDate() {
        return date;
    }

        public void setDate(String date) {
        this.date = date;
    }

        public String getSection() {
        return section;
    }

        public void setSection(String section) {
        this.section = section;
    }

        @Override
        public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", descript='" + descript + '\'' +
                ", date='" + date + '\'' +
                ", section='" + section + '\'' +
                '}';
    }
}

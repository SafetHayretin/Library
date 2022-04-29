package eu.deltasorce.internship.library.book;

public class OnlineBook {
    private boolean isDownloadable;
    private String readLink;
    private String downloadLink;

    public OnlineBook(boolean isDownloadable, String readlink, String downloadLink) {
        this.isDownloadable = isDownloadable;
        this.readLink = readlink;
        this.downloadLink = downloadLink;
    }

    public OnlineBook(boolean isDownloadable, String readLink) {
        this.isDownloadable = isDownloadable;
        this.readLink = readLink;
    }
}

package Structural.Composite;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        Folder folder1 = new Folder("Documents");
        folder1.addComponent(file1);
        folder1.addComponent(file2);

        Folder folder2 = new Folder("Work");
        folder2.addComponent(folder1);
        folder2.addComponent(new File("project.docx"));

        folder2.showDetails();
    }
}

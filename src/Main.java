import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        FileNode file1 = new FileNode("report.pdf", 500);
        FileNode file2 = new FileNode("notes.txt", 200);

        DirectoryNode documents = new DirectoryNode("Documents");
        documents.add(file2);
        DirectoryNode university = new DirectoryNode("University");
        university.add(file1);
        university.add(documents);

        List<FileSystemElement> elements = new ArrayList<>();
        elements.add(university);

        TotalSizeVisitor sizeVisitor = new TotalSizeVisitor();
        SearchVisitor searchVisitor = new SearchVisitor("notes.txt");

        for (FileSystemElement element : elements){
            element.accept(sizeVisitor);
            element.accept(searchVisitor);
        }
        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " bytes");
        System.out.println("File found: " + searchVisitor.isFound());
    }
}

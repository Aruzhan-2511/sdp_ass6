import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DirectoryNode implements FileSystemElement{
    private String name;
    private List<FileSystemElement> children = new ArrayList<>();

    public DirectoryNode(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void add(FileSystemElement element){
        children.add(element);
    }
    public List<FileSystemElement> getChildren(){
        return new ArrayList<>(children);
    }
    public void accept(FileSystemVisitor visitor){
        visitor.visitDirectory(this);
    }
}

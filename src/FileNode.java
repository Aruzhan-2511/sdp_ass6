public class FileNode implements FileSystemElement {
    private String name;
    private long size;

    public FileNode(String name, long size){
        this.name = name;
        this.size = size;
    }
    public String getName(){
        return name;
    }
    public long getSize(){
        return size;
    }
    public void accept(FileSystemVisitor visitor){
        visitor.visitFile(this);
    }
}

public class SearchVisitor implements FileSystemVisitor{
    private String targetName;
    private boolean found = false;

    public SearchVisitor(String targetName){
        this.targetName = targetName;
    }

    @Override
    public void visitFile(FileNode file) {
        if (file.getName().equals(targetName)){
            found = true;
        }
    }
    public void visitDirectory(DirectoryNode directory){
        if (directory.getName().equals(targetName)){
            found = true;
        }
        for (FileSystemElement element : directory.getChildren()){
            element.accept(this);
        }
    }
    public boolean isFound(){
        return found;
    }
}

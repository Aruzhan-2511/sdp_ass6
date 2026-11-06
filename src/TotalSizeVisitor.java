public class TotalSizeVisitor implements FileSystemVisitor{
    private long totalSize = 0;

    @Override
    public void visitFile(FileNode file) {
        totalSize += file.getSize();
    }

    @Override
    public void visitDirectory(DirectoryNode directory) {
        for (FileSystemElement element : directory.getChildren()){
            element.accept(this);
        }
    }

    public long getTotalSize() {
        return totalSize;
    }
}

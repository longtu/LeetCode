package wr.leetcode.algo.Linkedin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class TextFile implements Iterable<String> {
    Scanner scanner;

    public TextFile(String fileName) throws FileNotFoundException {
        scanner = new Scanner(new File(fileName));
    }

    /** Begin reading the file, line by line.
     * The returned Iterator.next() will return a line.
     */
    @Override
    public Iterator<String> iterator() {
        return new FileIterator(scanner);
    }
}

class FileIterator implements Iterator<String> {
    Scanner scanner;

    public FileIterator( Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    @Override
    public String next() {
        return scanner.nextLine();
    }
}

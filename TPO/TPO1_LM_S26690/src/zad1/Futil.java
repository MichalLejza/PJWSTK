package zad1;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class FileVisitor extends SimpleFileVisitor<Path>
{
    private FileChannel fcout;
    public FileVisitor(String outputPath)
    {
        try
        {
            this.fcout = FileChannel.open(Paths.get(outputPath), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
    {
        if (file.toString().endsWith(".txt") && attrs.isRegularFile())
        {
            FileChannel fcin = FileChannel.open(file, StandardOpenOption.READ);
            ByteBuffer buffer = ByteBuffer.allocate((int) fcin.size());
            fcin.read(buffer);

            Charset inCharset = Charset.forName("Cp1250");
            Charset outCharset = StandardCharsets.UTF_8;

            buffer.flip();

            CharBuffer charBuffer = inCharset.decode(buffer);
            buffer = outCharset.encode(charBuffer);
            fcout.write(buffer);

            return FileVisitResult.CONTINUE;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc)
    {
        return FileVisitResult.CONTINUE;
    }

    public void close() throws IOException
    {
        fcout.close();
    }
}

public class Futil
{
    public static void processDir(String dirName, String resultFileName)
    {
        try
        {
            FileVisitor fileVisitor = new FileVisitor(resultFileName);
            Files.walkFileTree(Paths.get(dirName), fileVisitor);
            fileVisitor.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

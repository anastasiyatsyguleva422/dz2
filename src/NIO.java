//import java.io.*;
//Задача 1
//public class NIO {
//    public static void main(String[] args) {
//        String inputFilePath = "input.txt.txt";
//        String outputFilePath = "output.txt";
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
//             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                writer.write(line.toUpperCase());
//                writer.newLine();  // Переход на новую строку
//            }
//            System.out.println("Файл успешно обработан и записан.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}


//задача 2
//interface TextProcessor {
//    String process(String text);
//}
//class SimpleTextProcessor implements TextProcessor {
//    @Override
//    public String process(String text) {
//        return text;
//    }
//}
//
//class UpperCaseDecorator implements TextProcessor {
//    private final TextProcessor wrapped;
//
//    public UpperCaseDecorator(TextProcessor wrapped) {
//        this.wrapped = wrapped;
//    }
//
//    @Override
//    public String process(String text) {
//        return wrapped.process(text).toUpperCase();
//    }
//}
//
//class TrimDecorator implements TextProcessor {
//    private final TextProcessor wrapped;
//
//    public TrimDecorator(TextProcessor wrapped) {
//        this.wrapped = wrapped;
//    }
//
//    @Override
//    public String process(String text) {
//        return wrapped.process(text).trim();
//    }
//}
//
//class ReplaceDecorator implements TextProcessor {
//    private final TextProcessor wrapped;
//
//    public ReplaceDecorator(TextProcessor wrapped) {
//        this.wrapped = wrapped;
//    }
//
//    @Override
//    public String process(String text) {
//        return wrapped.process(text).replace(" ", "_");
//    }
//}
//
//public class NIO {
//    public static void main(String[] args) {
//        TextProcessor processor = new ReplaceDecorator(
//                new UpperCaseDecorator(
//                        new TrimDecorator(new SimpleTextProcessor())
//                )
//        );
//        String result = processor.process(" Hello world ");
//        System.out.println(result);
//    }
//}

//Задача 3
//import java.io.*;
//import java.nio.*;
//import java.nio.channels.*;
//import java.nio.file.*;
//
//public class NIO {
//    public static void main(String[] args) throws IOException {
//        String filePath = "largeFile.txt";
//        String outputFilePathIO = "outputIO.txt";
//        String outputFilePathNIO = "outputNIO.txt";
//
//        // IO способ
//        long startIO = System.nanoTime();
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
//             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePathIO))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                writer.write(line);
//                writer.newLine();
//            }
//        }
//        long endIO = System.nanoTime();
//        System.out.println("Время выполнения IO: " + (endIO - startIO) + " ns");
//
//        // NIO способ
//        long startNIO = System.nanoTime();
//        Path path = Paths.get(filePath);
//        Path outputPathNIO = Paths.get(outputFilePathNIO);
//        Files.copy(path, outputPathNIO, StandardCopyOption.REPLACE_EXISTING);
//        long endNIO = System.nanoTime();
//        System.out.println("Время выполнения NIO: " + (endNIO - startNIO) + " ns");
//    }
//}
//Создание файла большого объема
//import java.io.*;
//
//public class NIO {
//    public static void main(String[] args) throws IOException {
//        String filePath = "largeFile.txt";
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//            for (int i = 0; i < 1000000; i++) {  // 1 миллион строк
//                writer.write("Строка " + i + ": Это тестовый файл для проверки IO и NIO.");
//                writer.newLine();
//            }
//        }
//        System.out.println("Файл " + filePath + " успешно создан.");
//    }
//}

//4
//import java.io.*;
//import java.nio.*;
//import java.nio.channels.*;
//
//public class NIO {
//    public static void copyFile(String source, String dest) throws IOException {
//        try (FileChannel sourceChannel = new FileInputStream(source).getChannel();
//             FileChannel destChannel = new FileOutputStream(dest).getChannel()) {
//            sourceChannel.transferTo(0, sourceChannel.size(), destChannel);
//        }
//    }
//
//    public static void main(String[] args) {
//        String sourceFile = "source.txt";
//        String destFile = "destination.txt";
//
//        try {
//            copyFile(sourceFile, destFile);
//            System.out.println("Файл успешно скопирован.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

//5
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.concurrent.*;

public class NIO {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("largeFile.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        channel.read(buffer, 0, null, new CompletionHandler<Integer, Void>() {
            @Override
            public void completed(Integer result, Void attachment) {
                buffer.flip(); // Переводим буфер в режим чтения
                System.out.println(new String(buffer.array(), 0, result));
                buffer.clear(); // Очистка буфера
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
            }
        });
    }
}


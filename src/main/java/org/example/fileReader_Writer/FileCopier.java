package org.example.fileReader_Writer;//package org.example.fileReader_Writer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopier {
    /**
     * Метод, который читает содержимое из файла sourcePath, а потом записывает в файл targetPath.
     * @param sourcePath файл для чтения.
     * @param targetPath файл для записи.
     * @throws IOException метод copyFileContent может выбрасывать исключение класса "IOException" или его
     * подклассов, который должен быть обработан в методе, вызывающим его
     */

    public static void copyFileContent(String sourcePath, String targetPath) throws IOException { //3

        /**
         * Записываю имя файла в объект File, чтобы сравнить, существует ли файл "source.txt".
         * Если нет, то я перехватываю исключение FileNotFoundException, которое отлавливается в IOException(//2 - в
         * файле Main), так как в сигнатуре метода указали throws IOException(//3), то передается выше, пока не
         * попадет в IOException(//2 - в файле Main)
         * Если этого не сделать, то copyFileContent(sourcePath, targetPath) создаст новый файл, например, с
         * именем "soce.txt", в который будет что-то записано, считано и скопировано в файл "target.txt".
         */

        File file = new File(sourcePath);
        if (!file.getName().equals("source.txt")) {
            throw new FileNotFoundException("Файл " + sourcePath + " не найден или изменён!!!");
        }

        /**
         * Создаю файл "source.txt" и произвожу в него запись, если проверка прошла, то есть файл существует
         */

        try (FileWriter fileWriter = new FileWriter(sourcePath)) {
            fileWriter.write("Hello, world!");
            System.out.println("Source file успешно создан");
        } catch (IOException e) { //4
            System.err.println("Такого файла не существует");
        }

        /**
         * Создаем объекты Path с относительными путями к файлам.
         * В данном случае pathOfTarget для проверки его существования.
         * pathOfSource - для проверки, заканчивается ли путь на "source.txt".
         */

        Path pathOfSource = Paths.get(sourcePath);
        System.out.println(pathOfSource);
        Path pathOfTarget = Paths.get(targetPath);


        /**
         * Используя метод класса Files, проверяем, существует ли данный файл "target.txt".
         * Если нет, то он будет создан.
         */

        /**
         * Далее, если target создан
         * Создаем буфер BufferedReader для чтения текста из файла "source.txt" путем конструктора FileReader
         * (источник для буфера), который указывает, откуда нужно считывать текст.
         * Создаем буфер BufferedWriter для записи в файл "target.txt" путем конструктора FileWriter (источника для
         * буфера), который указывает на файл, в который нужно записывать, а также вторым параметром говорим, что
         * первую строчку перезаписывать не нужно, и текст будет появляться на каждой новой строке
         */

        /**
         * Читаем каждую строку в файле "source.txt" до тех пор, пока последняя не окажется пустой.
         * В этот момент каждая прочитанная строка будет записываться в "target.txt", а при помощи newLine()
         * строки будут записываться не в одну, а каждый фрагмент на новой.
         * flush() - очищает буфер и записывает в файл "target.txt". Удобно, когда произошла непредвиденная
         * ситуация, и произошел вылет из программы. Данные в буфере не сохранились бы, а так, мы гарантируем,
         * что записи не потеряются.
         * Дальше идет обработка исключений, если что-то пошло не так.
         */

        if(!Files.exists(pathOfTarget)) {
            try {
                Files.createFile(pathOfTarget);
                System.out.println("Target file успешно создан");
                try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
                     BufferedWriter writer = new BufferedWriter(new FileWriter(targetPath, true))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                    writer.flush();
                    System.out.println("Tatget file успешно скопирован");
                } catch (FileNotFoundException e) {
                    System.err.println("Ошибка при открытии source или target file: " + e.getMessage());
                } catch (IOException e) {
                    System.err.println("Ошибка чтения из source или tatget file: " + e.getMessage());
                }
            } catch (IOException e) {
                System.err.println("Ошибка при создании target file: " + e.getMessage());
            }
        }
    }
}

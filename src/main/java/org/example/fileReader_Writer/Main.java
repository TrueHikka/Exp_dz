package org.example.fileReader_Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String sourcePath = "soure.txt";
        String targetPath = "target.txt";
        File file = new File(sourcePath);

        /**
         * Записываю имя файла в объект File, чтобы сравнить, существует ли файл "source.txt".
         * Для этого я при помощи getName получаю строку, а потом сравниваю.
         * Если не "source.txt", то я перехватываю исключение FileNotFoundException, которое отлавливается в IOException(//1).
         * Если этого не сделать, то в метод copyFileContent(sourcePath, targetPath) передастся несуществующий или
         * изменный файл, например, "soce.txt", тогда метод начнет свое выполнение, что нам не нужно
         */

        if (!file.getName().equals("source.txt")) {
            try {
                throw new FileNotFoundException("Файла " + file + " не существует%%%");
            } catch (IOException e) { //1
                System.err.println("Ошибка при создании файла source.txt: " + e.getMessage());
            }
        }
        try {
            FileCopier.copyFileContent(sourcePath, targetPath);
        } catch (IOException e) { //2
            System.err.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }
}


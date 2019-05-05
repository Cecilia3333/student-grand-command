package com.tw.command;

import com.tw.validator.InputValidator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Input {
    private List<String> output = new ArrayList<String>();
    private BufferedReader bufferedReader;

    {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public Input() {
    }

    public List<String> input() throws IOException {
        System.out.println("1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" + "请输入你的选择（1～3）：");
        String input = bufferedReader.readLine();

        if (input.equals("1")) {
            System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
            do {
                String inputContent = bufferedReader.readLine();
                if (new InputValidator(inputContent).validate1()) {
                    output.add("1");
                    output.add(inputContent);
                    break;
                }
                System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
            } while (true);

        } else if (input.equals("2")) {
            System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
            do {
                String inputContent = bufferedReader.readLine();
                if (new InputValidator(inputContent).validate2()) {
                    output.add("2");
                    output.add(inputContent);
                    break;
                }
                System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
            } while (true);
        } else {
            output.add("3");
        }

        return output;

    }

}

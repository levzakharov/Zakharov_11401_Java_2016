package ru.kpfu.itis.lzakharov;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean(name = "complexMatrix2x2Zero")
    public ComplexMatrix2x2 complexMatrix2x2Zero() {
        return new ComplexMatrix2x2();
    }

    @Bean(name = "complexMatrix2x2ZeroConstructor")
    public ComplexMatrix2x2 complexMatrix2x2ZeroConstructor() {
        return new ComplexMatrix2x2(complexNumberZero());
    }

    @Bean(name = "complexMatrix2x2OneConstructor")
    public ComplexMatrix2x2 complexMatrix2x2OneConstructor() {
        return new ComplexMatrix2x2(complexNumberOne());
    }

    @Bean(name = "complexMatrix2x2")
    public ComplexMatrix2x2 complexMatrix2x2() {
        return new ComplexMatrix2x2(complexNumberZero(), complexNumberOne(), complexNumberTwo(), complexNumberThree());
    }

    @Bean(name = "complexVector2D")
    public ComplexVector2D complexVector2D() {
        return new ComplexVector2D(complexNumberOne(), complexNumberOne());
    }

    @Bean(name = "cnum0")
    public ComplexNumber complexNumberZero() {
        return new ComplexNumber(0, 0);
    }

    @Bean(name = "cnum1")
    public ComplexNumber complexNumberOne() {
        return new ComplexNumber(1, 1);
    }

    @Bean(name = "cnum2")
    public ComplexNumber complexNumberTwo() {
        return new ComplexNumber(2, 2);
    }

    @Bean(name = "cnum3")
    public ComplexNumber complexNumberThree() {
        return new ComplexNumber(3, 3);
    }
}

package src.main.java.com.example.Math_API.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/mathapi")
public class MathAPIController {

    @GetMapping("/min")
    public List<Double> getMin(@RequestParam List<Double> numbers, @RequestParam int quantifier) {
        List<Double> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.subList(0, Math.min(quantifier, sortedNumbers.size()));
    }

    @GetMapping("/max")
    public List<Double> getMax(@RequestParam List<Double> numbers, @RequestParam int quantifier) {
        List<Double> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers, Collections.reverseOrder());
        return sortedNumbers.subList(0, Math.min(quantifier, sortedNumbers.size()));
    }

    @GetMapping("/avg")
    public double getAverage(@RequestParam List<Double> numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

    @GetMapping("/median")
    public double getMedian(@RequestParam List<Double> numbers) {
        List<Double> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        int size = sortedNumbers.size();
        if (size % 2 == 0) {
            int midIndex = size / 2;
            return (sortedNumbers.get(midIndex - 1) + sortedNumbers.get(midIndex)) / 2.0;
        } else {
            return sortedNumbers.get(size / 2);
        }
    }

    @GetMapping("/percentile")
    public double getPercentile(@RequestParam List<Double> numbers, @RequestParam double q) {
        List<Double> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        int n = sortedNumbers.size();
        int index = (int) Math.ceil(q * n / 100) - 1;
        return sortedNumbers.get(index);
    }
}

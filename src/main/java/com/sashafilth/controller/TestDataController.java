package com.sashafilth.controller;

import com.sashafilth.dao.TestData;
import com.sashafilth.repository.TestDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/test-data")
public class TestDataController {

    private final TestDataRepository testDataRepository;

    @Autowired
    public TestDataController(TestDataRepository testDataRepository) {
        this.testDataRepository = testDataRepository;
    }

    @GetMapping
    public ResponseEntity<String> insertTestData() {
        try {
            List<TestData> testDataList = getTestDataList();
            testDataRepository.saveAll(testDataList);
            return new ResponseEntity<>(HttpStatus.OK.toString(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), HttpStatus.OK);
        }

    }

    private List<TestData> getTestDataList() {
        List<TestData> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new TestData("Oleksandr", "Denysenko", "Sergiyouvich", 28, "male"));
        }
        return list;
    }
}

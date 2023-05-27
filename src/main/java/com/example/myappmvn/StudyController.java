package com.example.myappmvn;

import com.example.myappmvn.entity.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/study")
public class StudyController {
    
    private final StudyService studyService;

    @Autowired
    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }

    @GetMapping("/all")
    public List<Study> getAllStudies() {
        return studyService.getAllStudies();
    }

    @GetMapping("/{id}")
    public Study getStudyById(@PathVariable Long id) {
        return studyService.getStudyById(id);
    }

    @PostMapping
    public Study createStudy(@RequestBody Study study) {
        return studyService.createStudy(study);
    }

    @PutMapping("/{id}")
    public Study updateStudy(@PathVariable Long id, @RequestBody Study study) {
        return studyService.updateStudy(id, study);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudy(@PathVariable Long id) {
        studyService.deleteStudy(id);
        return ResponseEntity.noContent().build();
    }
}
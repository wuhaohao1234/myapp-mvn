package com.example.myappmvn;

import com.example.myappmvn.entity.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyService {
    private final StudyRepository studyRepository;

    @Autowired
    public StudyService(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    public List<Study> getAllStudies() {
        return studyRepository.findAll();
    }

    public Study getStudyById(Long id) {
        return studyRepository.findById(id).orElseThrow();
    }

    public Study createStudy(Study study) {
        return studyRepository.save(study);
    }

    public Study updateStudy(Long id, Study study) {
        Study existingStudy = getStudyById(id);
        existingStudy.setTitle(study.getTitle());
        existingStudy.setContent(study.getContent());
        return studyRepository.save(existingStudy);
    }

    public void deleteStudy(Long id) {
        studyRepository.deleteById(id);
    }
}

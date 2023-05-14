package Training.LifeSkills.controller;

import Training.LifeSkills.DTO.TrainingDTO;
import Training.LifeSkills.Service.TrainingService;
import Training.LifeSkills.mapper.TrainingMapper;
import Training.LifeSkills.model.Training;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/training")
@CrossOrigin("*")
public class TrainingController {

    private final TrainingService trainingService;
    private final TrainingMapper trainingMapper;

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Training> save(@RequestBody TrainingDTO trainingDTO) {
        return ResponseEntity.ok().body(trainingService.save(trainingMapper.toModel(trainingDTO)));
    }

    @CrossOrigin
    @GetMapping
    public List<Training> findAll() {

        return trainingService.findAllTraining();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<List<Training>> findTrainingsByUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(trainingService.findTrainingsByUser(id));
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteTrainings(@RequestBody List<Long> ids) {
        return ResponseEntity.ok().body(trainingService.deleteAllByIds(ids));
    }


}

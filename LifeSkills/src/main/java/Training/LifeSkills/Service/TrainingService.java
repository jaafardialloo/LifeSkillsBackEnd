package Training.LifeSkills.Service;

import Training.LifeSkills.Repository.TrainingRepository;
import Training.LifeSkills.model.Training;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrainingService {

  private final TrainingRepository trainingRepository;

  public Training save(Training training) {
      return trainingRepository.save(training);
  }

  public List<Training> findAllTraining() {
      return trainingRepository.findAll();
  }

  public Training findTrainingById(Long id) {
      return trainingRepository.findById(id).orElseThrow(IllegalArgumentException::new);
  }

    public List<Training> findTrainingsByUser(Long userId) {
        return trainingRepository.findAllByTrainerId(userId);
    }

    public boolean deleteAllByIds(List<Long> ids) {
      trainingRepository.deleteAllById(ids);
      return true;
    }
}

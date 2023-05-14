package Training.LifeSkills.Repository;

import Training.LifeSkills.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TrainingRepository extends JpaRepository<Training,Long> {

    List<Training> findAllByTrainerId(Long trainerId);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);
}

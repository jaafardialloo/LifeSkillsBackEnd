package Training.LifeSkills.security.mapper;

import java.util.List;

public interface Mapper<M, D> {

  M toModel(D dto);

  D toDto(M model);

  List<M> toModels(List<D> dtos);

  List<D> toDtos(List<M> models);

  Class<M> getModelClass();

}

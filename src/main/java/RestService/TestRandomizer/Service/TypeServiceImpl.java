//package RestService.TestRandomizer.Service;
//
//import RestService.TestRandomizer.model.Type;
//import RestService.TestRandomizer.repositories.TypeRepository;
//
//import java.util.List;
//
//public class TypeServiceImpl implements TypeService {
//    private final TypeRepository typeRepository;
//
//    public TypeServiceImpl(TypeRepository typeRepository){
//        this.typeRepository = typeRepository;
//    }
//    @Override
//    public Type findTypeById(Long id){
//        return typeRepository.findById(id).get();
//    }
//    @Override
//    public List<Type> findAllTypes(){
//        return typeRepository.findAll();
//    }
//    @Override
//    public Type saveType(Type type){
//        return typeRepository.save(type);
//    }
//    @Override
//    public List<Type> saveAllTypes(List<Type> types){
//        return typeRepository.saveAll(types);
//    }
//    @Override
//    public void deleteTypeById(long id){
//        if(typeRepository.existsById(id)){
//            typeRepository.deleteById(id);
//        }
//    }
//}

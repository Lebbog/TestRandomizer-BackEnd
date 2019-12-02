//package RestService.TestRandomizer.controllers;
//
//import RestService.TestRandomizer.Service.TypeService;
//import RestService.TestRandomizer.model.Type;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//
//@CrossOrigin
//@RestController
//@RequestMapping(AuthorController.BASE_URL)
//public class TypeController {
//    public static final String BASE_URL = "api/v1/testrandomizer/types";
//    private final TypeService typeService;
//
//    public TypeController(TypeService typeService){
//        this.typeService = typeService;
//    }
//    //@RequestBody Type type
//    @GetMapping
//    public List<Type> getTypes() {
//        return typeService.findAllTypes();
//    }
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Type addType(@RequestBody Type type){
//        if(type.getType() == "") {
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST, "Type cannot be empty"
//            );
//        }
//        return typeService.saveType(type);
//    }
//    @DeleteMapping("/{typeId}")
//    public void deletTypeById(@PathVariable (value = "typeId") Long typeId){
//        typeService.deleteTypeById(typeId);
//    }
//}

package guru.springframework.pets.services;

public class PetServiceFactory {

    public PetService getPetService(String petType){
        return switch (petType){
            case "dog" ->  new DogPetService();
            case "cat" -> new CatPetService();
            default ->  new DogPetService();
        };
    }

}

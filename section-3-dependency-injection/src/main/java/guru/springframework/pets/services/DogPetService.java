package guru.springframework.pets.services;

public class DogPetService implements PetService{

    @Override
    public String getPetType() {
        return "Dogs are the best!";
    }

}

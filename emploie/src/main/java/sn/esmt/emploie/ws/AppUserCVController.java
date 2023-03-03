package sn.esmt.emploie.ws;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.esmt.emploie.dao.AppUserCVRepository;
import sn.esmt.emploie.entities.AppUserCVEntity;

import java.util.List;

@RestController
@RequestMapping(value = "/userscv")
@AllArgsConstructor
public class AppUserCVController {
    private AppUserCVRepository appUserCVRepository;

    @PostMapping(path = "/save")
    public AppUserCVEntity save(@RequestBody AppUserCVEntity appUserCVEntity){
        return appUserCVRepository.save(appUserCVEntity);
    }
    @GetMapping(path = "/all")
    public List<AppUserCVEntity> getAll(){
        return appUserCVRepository.findAll();
    }

    @GetMapping(path = "/login")
    public ApiLoginResponse login(@RequestParam String email, @RequestParam String nom, @RequestParam String prenom){
        AppUserCVEntity appUserCVEntity = appUserCVRepository.findByEmailAndNomAndPrenom(email, nom, prenom);;
        if(appUserCVEntity != null){

            return new ApiLoginResponse("OK", email);
        }else{
            //signifie aucun utilisateur correspondant n'a été trouvé
            //connexion sans resultat...
            return new ApiLoginResponse("NOK", email);
        }
    }

}

package com.example.demo5;

import com.example.demo5.entities.Client;
import com.example.demo5.entities.Donnee;
import com.example.demo5.entities.ModuleBase;
import com.example.demo5.entities.UsefulEntity;
import com.example.demo5.fonc.Fonction;
import com.example.demo5.fonc.Utilites;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/solar")
@CrossOrigin("*")
public class SolarController {
    @GetMapping("listeclient")
    public ArrayList<Client> listeclient () throws Exception{
        return Fonction.getListClient();
    }

    @GetMapping("listedonnees")
    public ArrayList<Donnee> listedonnee () throws Exception{
        return Fonction.getListDonnee();
    }

    @GetMapping("listedonneespec/{mois}/{jour}/{heure1}/{heure2}")
    public ArrayList<Donnee> listedonneespec(@PathVariable("mois")String mois, @PathVariable("jour")String jour,@PathVariable("heure1") String heure1,@PathVariable("heure2") String heure2) throws Exception{
        return Fonction.getListDonneeSpecifique(mois,jour,heure1,heure2);
    }

    @GetMapping("insertdonnees/{idmodule}/{voltagepanneau}/{voltageoutput}/{voltagebatterie}/{production}/{consommation}")
    public void insertDonnees(@PathVariable("idmodule") String idmodule, @PathVariable("voltagepanneau") String voltagepanneau, @PathVariable("voltageoutput") String voltageoutput, @PathVariable("voltagebatterie") String voltagebatterie, @PathVariable("production") String production, @PathVariable("consommation") String consommation){
        try{
            Fonction.insertDonnee(idmodule, voltagepanneau, voltageoutput, voltagebatterie, production, consommation);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("insertclient/{nom}/{prenom}/{email}/{pass}/{lienimage}/{adresse}/{codepostal}")
    public void insertClient(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom, @PathVariable("email") String email, @PathVariable("pass") String pass, @PathVariable("lienimage") String lienimage, @PathVariable("adresse") String adresse, @PathVariable("codepostal") String codepostal){
        try{
            Fonction.signUpClient(nom, prenom, email, pass, lienimage, adresse, codepostal);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("loginclient/{email}/{pass}")
    public UsefulEntity loginclient(@PathVariable("email") String email, @PathVariable("pass") String pass) throws Exception{
        return Fonction.loginClient(email,pass);
    }

    @GetMapping("clientbyid/{idclient}")
    public Client clientbyid(@PathVariable("idclient") String idclient) throws Exception{
        return Fonction.getClientById(Integer.parseInt(idclient));
    }

    @GetMapping("listemodule")
    public ArrayList<ModuleBase> listemodule() throws Exception{
        return Fonction.getListModule();
    }

    @GetMapping("insertmodule/{qrcode}/{idbatterie}")
    public void insertModule(@PathVariable("qrcode") String qrcode, @PathVariable("idbatterie") String idbatterie) throws Exception{
        Fonction.insertModule(qrcode,idbatterie);
    }

    @GetMapping("modulebyid/{idmodule}")
    public ModuleBase moduleById(@PathVariable("idmodule") String idmodule) throws Exception{
        return Fonction.getModuleById(Integer.parseInt(idmodule));
    }

    @GetMapping("modulebyidclient/{idclient}")
    public ModuleBase moduleByIdClient(@PathVariable("idclient") String idclient) throws Exception{
        return Fonction.moduleByIdClient(Integer.parseInt(idclient));
    }

    @GetMapping("attributionmoduleclient/{idclient}/{idmodule}")
    public void Attribution(@PathVariable("idclient") String idclient, @PathVariable("idmodule") String idmodule){
        Fonction.AttributionModuleClient(idmodule,idclient);
    }

    @GetMapping("deletedata")
    public static void deletedata(){
        Fonction.DeleteData();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import java.util.HashMap;

/**
 *
 * @author USUARIO
 */
public class PrototypePersonaje {

    private HashMap<String, Personaje> prototipos = new HashMap<String, Personaje>();

    public PrototypePersonaje() {
        Director director = new Director();
        BuilderPersonaje humano = new ConstructorPersonajeHumano();
        BuilderPersonaje enano = new ConstructorPersonajeEnano();
        BuilderPersonaje elfo = new ConstructorPersonajeElfo();
        director.setBuilderPersonaje(humano);
        director.construirPersonaje();
        Personaje personajeH = director.getPersonaje();
        director.setBuilderPersonaje(enano);
        director.construirPersonaje();
        Personaje personajeE = director.getPersonaje();
        director.setBuilderPersonaje(elfo);
        director.construirPersonaje();
        Personaje personajeF = director.getPersonaje();
        
        prototipos.put("humano", personajeH);
        prototipos.put("enano", personajeE);
        prototipos.put("elfo", personajeF);
    }

    public Object prototipo(String tipo) throws CloneNotSupportedException {
        return prototipos.get(tipo).clone();
    }
    
    

}

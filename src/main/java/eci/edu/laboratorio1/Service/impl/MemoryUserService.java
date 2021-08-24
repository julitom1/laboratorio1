package eci.edu.laboratorio1.Service.impl;

import eci.edu.laboratorio1.Service.UserService;
import eci.edu.laboratorio1.data.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MemoryUserService implements UserService {

    private static final ConcurrentHashMap<String,User> usuarios = new ConcurrentHashMap<>();
    @Override
    public User create(User user) {
        user.setId(generarId());
        usuarios.put(user.getId(),user);
        return user;
    }

    @Override
    public User findById(String id) {
        User usuario=null;
        if(usuarios.containsKey(id)){
            usuario=usuarios.get(id);
        }
        return usuario;
    }

    @Override
    public List<User> all() {
        List<User> usuarioLista=new ArrayList<>();
        for(String userId : usuarios.keySet()){
        	usuarioLista.add(usuarios.get(userId));
        }
        return usuarioLista;
    }

    @Override
    public void deleteById(String id) {
    	if(usuarios.containsKey(id)) {
    		usuarios.remove(id);
    	}
    }

    @Override
    public User update(User user, String userId) {
        usuarios.put(userId,user);
        return user;
    }
    
    private String generarId() {
    	int mayorId=0;
    	for(String userId : usuarios.keySet()){
        	if(mayorId<Integer.parseInt(userId)) {
        		mayorId=Integer.parseInt(userId);
        	}
        }
    	mayorId+=1; 
    	return mayorId+"";
    }
   
}

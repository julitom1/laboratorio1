package eci.edu.laboratorio1.Service.impl;

import eci.edu.laboratorio1.Service.UserService;
import eci.edu.laboratorio1.Service.usersNotFoundException;
import eci.edu.laboratorio1.data.User;


import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.time.LocalDate;

@Service
public class MemoryUserService implements UserService {

    private static final ConcurrentHashMap<String,User> usuarios = new ConcurrentHashMap<>();
    @Override
    public User create(User user) {
    	user.setId(generarId());
    	LocalDate date=LocalDate.now();
    	user.setCreated(date);
        usuarios.put(user.getId(),user);
        return user;
    }

    @Override
    public User findById(String id) throws usersNotFoundException {
        User usuario=null;
        if(usuarios.containsKey(id)){
            usuario=usuarios.get(id);
        }else {
			throw new usersNotFoundException("Not found user with id: "+id);
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
    public void deleteById(String id) throws usersNotFoundException {
    	if(usuarios.containsKey(id)) {
    		usuarios.remove(id);
    	}else {
			throw new usersNotFoundException("Not found user with id: "+id);
		}
    }

    @Override
    public User update(User user, String userId) throws usersNotFoundException {
    	user.setId(userId);
    	user.setCreated(findById(userId).getCreated());
    	if(usuarios.containsKey(userId)) {
    		usuarios.put(userId,user);
    	}else {
			throw new usersNotFoundException("Not found user with id: "+userId);
		}
        
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

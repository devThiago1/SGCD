import { Request, Response } from "express";
import { user_adress_Repository } from "../repositories/user_adress_Repository";
import { user_info_Repository } from "../repositories/user_info_Repository";
import * as Joi from 'joi';
import { Adress } from "../entities/Adress";
import { User } from "../entities/User";
import dataVerification from "../services/dataVerification";
import bcrypt from 'bcrypt';

export class UserController{
    async addUser(req: Request, res: Response){
        
        const newUser = {
        first_name_user: req.body.first_name_user,
        last_name_user:  req.body.last_name_user,
        cpf_user: req.body.cpf_user,
        email_user: req.body.email_user,
        password_user: req.body.password_user,
        number_user: req.body.number_user,
        bairro_user: req.body.bairro_user,
        cep_user: req.body.cep_user,
        complemento_user: req.body.complemento_user,
        number_adress_user: req.body.number_adress_user,
        rua_user: req.body.rua_user,
        }


        try{
            const dataVerf = dataVerification(newUser);
                if(!dataVerf){
                    return res.status(204).json({message: 'Campos Inválidos'});
                } else {

                    const hashPassword = await bcrypt.hash(newUser.password_user, 10);
                    const hashCpf =  await bcrypt.hash(newUser.cpf_user, 10);

                    const Address = new Adress();
                    Address.bairro_user = newUser.bairro_user;
                    Address.rua_user = newUser.rua_user;
                    Address.cep_user = newUser.cep_user;
                    Address.complemento_user = newUser.complemento_user;
                    Address.number_adress_user = newUser.number_adress_user;
                    await user_adress_Repository.manager.save(Address)
                    
                    const user = new User();
                    user.first_name_user = newUser.first_name_user;
                    user.last_name_user = newUser.last_name_user;
                    user.email_user = newUser.email_user;
                    user.password_user = hashPassword;
                    user.cpf_user = hashCpf;
                    user.number_user = newUser.number_user;
                    user.Adress = Address;
                    await user_info_Repository.manager.save(user);

                    
                    

                    return res.status(201).redirect('/sucessCadastro');

                    
                } 
        } catch (error) {
            console.log(error);
            return res.status(500).json({message: 'Internal Server Error'});
        }
    
    }
}
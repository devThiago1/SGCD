import { Request, Response } from "express";

export class UserController{
    async addUser(req: Request, res: Response){
        
        const first_name = req.body.first_name;
        const last_name = req.body.last_name;
        const cpf_user = req.body.cpf_user;
        const email_user = req.body.email_user;
        const password_user = req.body.password_user;
        const number_user = req.body.number_user;
        const bairro_user = req.body.bairro_user;
        const cep_user = req.body.cep_user;
        const complemento_user = req.body.complemento_user;
        const number_adress_user = req.body.number_adress_user;
        const rua_user = req.body.rua_user;


        try{

        }catch(error){
            console.log(error);
            return res.status(500).json({message: 'Internal Server Error'});
        }
    
    }
}
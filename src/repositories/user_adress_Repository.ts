import { AppDataSource } from "../data-source";
import { Adress } from "../controller/entities/Adress";

export const user_adress_Repository = AppDataSource.getRepository(Adress);
import { AppDataSource } from "../data-source";
import { User } from "../entities/User";



export const user_info_Repository = AppDataSource.getRepository(User);
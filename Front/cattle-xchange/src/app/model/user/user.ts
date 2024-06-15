import { Role } from "./role";

export interface User {
   id: string,
   document: string,
   name: string,
   lastName?: string,
   email: string,
   password: string,
   creationDate: Date,
   role: Role,
}

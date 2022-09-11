import { User } from "./user";

export class Rendezvous {
    idRdv!:number;
    nom_client!: String;
    prenom_client!: String;
    commentaire!: String;
    numtel!: number;
    date_rdv!: Date;
    etat!: Boolean;
    user!:User;
}

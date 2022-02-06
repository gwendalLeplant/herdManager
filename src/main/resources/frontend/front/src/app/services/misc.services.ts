import { Injectable, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http'
import { Subject, Subscription } from 'rxjs';

export enum data{
    COLOR = 0,
    RACE,
    PERSON,
    GENOTYPE,
    LOCUS_AGOUTI,
    LOCUS_BROWN,
    LOCUS_FADED,
    LOCUS_SPOTTED,
    LAST
}

@Injectable({
  providedIn: 'root'
})
export class MiscService{
    private urlBase = "http://localhost:8080/WS/";
    private idx:number = 0;

    private datas:any[][] = [];
    private urls:string[] = ["color","race","person","genotype","locusAgouti","locusBrown","locusFaded","locusSpotted"];
    private datasSubject:any[] = [];

    constructor(private httpClient:HttpClient){
        for(let i = 0;i<data.LAST;i++){
            this.datasSubject[i] = new Subject();
        }
    }    

    async miscSubscribe(subscription:Subscription,index:data):Promise<any[]>{
        // Récupération de la base de donnée
        this.getAllFromServer(index);
        // Instanciation du tableau à retourner
        let app:any[] = [];
        // Abonnement et mise à jour du tableau
        subscription = this.datasSubject[index].subscribe(
            (p: any) => {
            app = p;
            }
        );
        // Emission de la mise à jour du tableau
        this.emitSubject(index);
        return app;
    }

    emitSubject(index:data){
        this.datasSubject[index].next(this.datas[index]);
    }

    getAllFromServer(index:data){
        let url = this.urlBase+this.urls[index];
        this.httpClient.get<any[]>(url,{responseType:'json'}).subscribe(
        response => {
            if(response != undefined){
            this.idx=0;
            this.datas[index] = [];
            for(let o of response){
            this.idx++; 
            this.datas[index].push(o);
            }
        }
            this.emitSubject(index);  
            console.log(this.datas[index]);
        }
        );
    }
}
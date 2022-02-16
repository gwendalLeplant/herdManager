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

    private urls:string[] = ["color","race","person","genotype","locusAgouti","locusBrown","locusFaded","locusSpotted"];
    public datasSubject:any[] = [];

    constructor(private httpClient:HttpClient){
        for(let i = 0;i<data.LAST;i++){
            this.datasSubject[i] = new Subject();
        }
    }  

    emitSubject(index:data,tab:any[]){
        this.datasSubject[index].next(tab);
    }

    getAllFromServer(index:data,tab:any[]){
        let url = this.urlBase+this.urls[index]+"/";
        this.httpClient.get<any[]>(url,{responseType:'json'}).subscribe(
            response => {
                if(response != undefined){
                    this.idx=0;
                    tab = [];
                    for(let o of response){
                    this.idx++; 
                    tab.push(o);
                    }
                }
                this.emitSubject(index,tab);  
            }
        );
    }
}
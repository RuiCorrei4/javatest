import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  public getCountry(){
    const criteria = [ {Financiamneto:1, A:48, B:13499.99} ];
    //return this.httpClient.get('http://localhost:8080/GetFinancingResult'+'/?criteria='+ encodeURIComponent( JSON.anyify(criteria)));
  }

  public postSaveClientFinancing(name: any, cellphone: any, financing:any, months: any ){
    return this.httpClient.post('http://localhost:8080/SaveClientFinancing', {"name": name, "cellphone": cellphone, "financing": financing,"a": months});
  }

  public PostFinancingValeu(interno: any, externo: any,){
    return this.httpClient.post('http://localhost:8080/PostFinancingValeu', {"interno": interno, "externo": externo, });
  }

  public postFinancingResult(A: any, B: any, financing:any){
    return this.httpClient.post('http://localhost:8080/GetFinancingResult', {"A": A, "B": B, "Financiamneto":financing});
  }
  constructor(private httpClient: HttpClient) {
    
   }
  
}

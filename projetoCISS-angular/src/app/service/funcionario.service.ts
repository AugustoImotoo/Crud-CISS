import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {first, Observable, pipe} from 'rxjs';
import { Funcionario } from "../models/Funcionario";

@Injectable()
export class FuncionarioService {
  API = 'http://localhost:8080/api/funcionarios';
  constructor(private http: HttpClient) { }

  getFuncionario(): Observable<Funcionario[]> {
    return this.http.get<Funcionario[]>(this.API);
  }
  createFuncionario(record: Partial<Funcionario>) {
    return this.http.post<Funcionario>(this.API, record);
  }
  editFuncionario(record: Partial<Funcionario>) {
    return this.http.put<Funcionario>(`${this.API}/${record.id}`, record).pipe(first());
  }

  deleteFuncionario(id: number) {
    return this.http.delete(`${this.API}/${id}`).pipe(first());
  }
}

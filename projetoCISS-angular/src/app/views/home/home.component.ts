import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTable } from '@angular/material/table';
import { Funcionario } from "../../models/Funcionario";
import { FuncionarioService } from "../../service/funcionario.service";
import { ElementDialogComponent } from 'src/app/shared/element-dialog/element-dialog.component';
import {Observable, of} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  providers: [FuncionarioService]
})
export class HomeComponent implements OnInit {
  @ViewChild(MatTable)
  table!: MatTable<any>;
  displayedColumns: string[] = ['id', 'nome', 'sobrenome', 'email', 'nis', 'actions'];
  dataSource!: Funcionario[];

  constructor(
    public dialog: MatDialog,
    public funcionarioService: FuncionarioService
  ) {
    this.funcionarioService.getFuncionario()
      .subscribe((data: Funcionario[]) => {
        this.dataSource = data;
      });
  }

  ngOnInit(): void {
  }

  openDialog(funcionario: Funcionario | null): void {
    const dialogRef = this.dialog.open(ElementDialogComponent, {
      width: '250px',
      data: funcionario === null ? {
        id: null,
        nome: '',
        sobrenome: '',
        email: '',
        nis: null
      } : {
        id: funcionario.id,
        nome: funcionario.nome,
        sobrenome: funcionario.sobrenome,
        email: funcionario.email,
        nis: funcionario.nis
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        if (this.dataSource.map(p => p.id).includes(result.id)) {
          this.funcionarioService.editFuncionario(result)
            .subscribe((data: Funcionario) => {
              const index = this.dataSource.findIndex(p => p.id === data.id);
              this.dataSource[index] = data;
              this.table.renderRows();});
        } else {
          this.funcionarioService.createFuncionario(result)
            .subscribe((data: Funcionario) => {
              this.dataSource.push(data);
              this.table.renderRows();});
        }
      }
    });
  }

  editarFuncionario(element: Funcionario): void {
    this.openDialog(element);
  }

  deletarFuncionario(position: number): void {
    this.funcionarioService.deleteFuncionario(position)
      .subscribe(() => {
        this.dataSource = this.dataSource.filter(p => p.id !== position);
      });
  }


}

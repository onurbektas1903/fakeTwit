import { DatePipe } from '@angular/common';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'dateTimeFormat'})
export class DateTimeFormatPipe extends DatePipe implements PipeTransform {
  transform(value: any, args?: any): any {
    let format;
    if(args && args ==="hour"){
      format ='dd/MM/yyyy HH:mm:ss'
    } else{
      format='dd/MM/yyyy';
    }
    return super.transform(value, format);
  }
}

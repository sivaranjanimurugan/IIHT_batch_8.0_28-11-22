import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ellipsis'
})
export class EllipsisPipe implements PipeTransform {

  transform(value: string, ...args: string[]): unknown {
    let val;
    if(value.length > 30){
      val = value.substring(0, 30) + "..."
    }
    return val;
  }

}

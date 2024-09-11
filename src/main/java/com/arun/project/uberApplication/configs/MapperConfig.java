package com.arun.project.uberApplication.configs;

import com.arun.project.uberApplication.dto.PointDto;
import com.arun.project.uberApplication.utils.GeometryUtil;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper getMapper(){
        ModelMapper mapper=new ModelMapper();

        //Converting from PointDto to Point
        mapper.typeMap(PointDto.class, Point.class).setConverter(context -> {
            PointDto pointDto=context.getSource();
            return GeometryUtil.createPoint(pointDto);
        });

        //Converting from Point to PointDto
        mapper.typeMap(Point.class,PointDto.class).setConverter(context-> {
            Point point=context.getSource();
            double coordinates[]={
                    point.getX(),
                    point.getY()
            };
             return new PointDto(coordinates);
        });

        return mapper;
    }

}

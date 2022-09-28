package com.solvd.airport.services;

import com.solvd.airport.models.Bag;

public interface IBagService {
    public void createBag(Bag b);
    public void parseDOM(String xsdFile, String xmlFile);
    public void getBagFromXML(String xsdFile, String xmlFile);
    public void createXML(String xmlFile);
}

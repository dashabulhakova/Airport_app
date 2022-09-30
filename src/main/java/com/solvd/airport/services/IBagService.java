package com.solvd.airport.services;

import com.solvd.airport.models.Bag;

public interface IBagService {
    public void createBag(Bag b);
    public void parseDOM(String xmlFile, String xsdFile);
    public void getBagFromXML(String xmlFile, String xsdFile);
    public void createXML(String xmlFile);
}

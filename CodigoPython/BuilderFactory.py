# "Builder" example.
# This example was elaborated from Partha Kuchana's example of his book "Software Architecture Design Patterns in Java" by Jefferson Jiménez and
# adapted by Henry Alberto Diosa

from Builder import CandSrchBuilder, EmpSrchBuilder, EnterpriseSrchBuilder

class BuilderFactory():
    def getUIBuilder(self, typeL, frame):
        from SQLBuilderUI import SQLBuilderUI
        if (typeL == SQLBuilderUI.CANDIDATE):
            return CandSrchBuilder(frame)
        elif (typeL == SQLBuilderUI.EMPLOYER):
            return EmpSrchBuilder(frame)
        elif (typeL == SQLBuilderUI.ENTERPRISE):
            return EnterpriseSrchBuilder(frame)
        return None
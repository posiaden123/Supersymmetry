import gregtech.api.GregTechAPI;
import gregtech.api.unification.material.Material;

import static gregtech.api.unification.material.Materials.*;
import static globals.Globals.*

ELECTROLYZER = recipemap('electrolyzer')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
CSTR = recipemap('continuous_stirred_tank_reactor')
BATCH_REACTOR = recipemap('batch_reactor')
DISTILLERY = recipemap('distillery')

//ACANTHITE ROASTING (PRIMITIVE), (75%)
ROASTER.recipeBuilder()
    .inputs(ore('dustAcanthite'))
    .inputs(ore('dustTinyCalcite'))
    .fluidInputs(fluid('oxygen') * 3000)
    .chancedOutput(ore('dustSilverOxide').first() * 3, 7500, 0)
    .fluidOutputs(fluid('sulfur_dioxide') * 1000)
    .duration(60)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustAcanthite'))
    .inputs(ore('dustTinyCalcite'))
    .fluidInputs(fluid('air') * 4500)
    .chancedOutput(ore('dustSilverOxide').first() * 3, 7500, 0)
    .fluidOutputs(fluid('sulfur_dioxide') * 1000)
    .duration(60)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustSilverOxide') * 3)
    .outputs(ore('dustSilver').first() * 2)
    .fluidOutputs(fluid('oxygen') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//CYANIDE LEACHING (UNIVERSAL)
//ACANTHITE (100%)
BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustAcanthite') * 3)
    .inputs(ore('dustSodiumCyanide') * 12)
    .fluidInputs(fluid('distilled_water') * 8000)
    .fluidOutputs(fluid('sulfidic_silver_cyanide_solution') * 1000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

CSTR.recipeBuilder()
    .fluidInputs(fluid('sulfidic_silver_cyanide_solution') * 50)
    .fluidInputs(fluid('hydrochloric_acid') * 100)
    .fluidOutputs(fluid('silver_cyanide_solution') * 50)
    .fluidOutputs(fluid('hydrogen_sulfide') * 50)
    .duration(12)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('silver_cyanide_solution') * 1000)
    .notConsumable(metaitem('stickSilver'))
    .notConsumable(metaitem('graphite_electrode'))
    .outputs(metaitem('dustSilver'))
    .fluidOutputs(fluid('chlorine') * 2000)
    .fluidOutputs(fluid('sodium_cyanide_solution') * 2000)
    .duration(480)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//PYRARGYRITE (90%)
BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustPyrargyrite') * 7)
    .inputs(ore('dustSodiumCyanide') * 18)
    .fluidInputs(fluid('distilled_water') * 6000) 
    .fluidOutputs(fluid('sulfidic_pyrargyrite_cyanide_leach_solution') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .fluidInputs(fluid('sulfidic_pyrargyrite_cyanide_leach_solution') * 1000)
    .fluidInputs(fluid('hydrochloric_acid') * 6000)
    .fluidOutputs(fluid('pyrargyrite_cyanide_leach_solution') * 900)
    .fluidOutputs(fluid('hydrogen_sulfide') * 3000)
    .duration(120)  
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('pyrargyrite_cyanide_leach_solution') * 1000)
    .notConsumable(metaitem('stickSilver'))
    .notConsumable(metaitem('graphite_electrode'))
    .outputs(ore('dustSilver').first() * 3)
    .outputs(ore('dustAntimony').first())
    .fluidOutputs(fluid('chlorine') * 6000) 
    .fluidOutputs(fluid('sodium_cyanide_solution') * 6000)
    .duration(480)  
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//STEPHANITE (100%)
BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustStephanite') * 10)
    .inputs(ore('dustSodiumCyanide') * 30)
    .fluidInputs(fluid('distilled_water') * 12000)
    .fluidOutputs(fluid('sulfidic_stephanite_cyanide_leach_solution') * 1000)
    .duration(240)  
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

CSTR.recipeBuilder()
    .fluidInputs(fluid('sulfidic_stephanite_cyanide_leach_solution') * 1000)
    .fluidInputs(fluid('hydrochloric_acid') * 8000)
    .fluidOutputs(fluid('stephanite_cyanide_leach_solution') * 1000)
    .fluidOutputs(fluid('hydrogen_sulfide') * 4000)
    .duration(12)  
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('stephanite_cyanide_leach_solution') * 1000)
    .notConsumable(metaitem('stickSilver'))
    .notConsumable(metaitem('graphite_electrode'))
    .outputs(ore('dustSilver').first() * 5)
    .outputs(ore('dustAntimony').first() * 1)
    .fluidOutputs(fluid('chlorine') * 8000)
    .fluidOutputs(fluid('sodium_cyanide_solution') * 10000)
    .duration(480)  
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//THIOSULFATE LEACHING (SPECIALIZED) (100%)
//PYRARGYRITE
BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustPyrargyrite') * 7)
    .inputs(ore('dustSodiumThiosulfate') * 42)
    .fluidInputs(fluid('distilled_water') * 5000)
    .fluidOutputs(fluid('pyrargyrite_thiosulfate_leach_solution') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustSodiumSulfide') * 9)
    .fluidInputs(fluid('pyrargyrite_thiosulfate_leach_solution') * 2000)
    .outputs(ore('dustSilverSulfide').first() * 9)
    .fluidOutputs(fluid('thiosulfate_thioantimonite_solution') * 2000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .fluidInputs(fluid('thiosulfate_thioantimonite_solution') * 1000)
    .fluidInputs(fluid('iron_iii_chloride_solution') * 1000)
    .outputs(metaitem('dustIronThioantimonite') * 5)
    .fluidOutputs(fluid('sodium_thiosulfate_solution') * 6000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustIronThioantimonite') * 10)
    .fluidInputs(fluid('hydrochloric_acid') * 6000)
    .outputs(metaitem('dustAntimonyIiiSulfide') * 5)
    .fluidOutputs(fluid('hydrogen_sulfide') * 3000)
    .fluidOutputs(fluid('diluted_iron_iii_chloride_solution') * 2000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('diluted_iron_iii_chloride_solution') * 3000)
    .outputs(ore('dustIronIiiChloride').first() * 4)
    .fluidOutputs(fluid('water') * 3000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//PROUSTITE
BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustProustite') * 7)
    .inputs(ore('dustSodiumThiosulfate') * 42)
    .fluidInputs(fluid('distilled_water') * 5000)
    .fluidOutputs(fluid('proustite_thiosulfate_leach_solution') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustSodiumSulfide') * 9)
    .fluidInputs(fluid('proustite_thiosulfate_leach_solution') * 2000)
    .outputs(metaitem('dustSilverSulfide') * 9)
    .fluidOutputs(fluid('thiosulfate_thioarsenite_solution') * 2000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .fluidInputs(fluid('thiosulfate_thioarsenite_solution') * 1000)
    .fluidInputs(fluid('iron_iii_chloride_solution') * 1000)
    .outputs(metaitem('dustIronThioarsenite') * 5)
    .fluidOutputs(fluid('sodium_thiosulfate_solution') * 6000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustIronThioarsenite') * 10)
    .fluidInputs(fluid('hydrochloric_acid') * 6000)
    .outputs(metaitem('dustArsenicIiiSulfide') * 5)
    .fluidOutputs(fluid('hydrogen_sulfide') * 3000)
    .fluidOutputs(fluid('diluted_iron_iii_chloride_solution') * 2000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//SILVER CHLORIDE
BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustSilverChloride') * 4)
    .inputs(ore('dustZinc'))
    .fluidInputs(fluid('distilled_water') * 1000)
    .notConsumable(fluid('sulfuric_acid') * 10)
    .outputs(metaitem('dustSilver') * 2)
    .fluidOutputs(fluid('zinc_chloride_solution') * 1000)
    .duration(360)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('zinc_chloride_solution') * 1000)
    .outputs(metaitem('dustZincChloride') * 3)
    .fluidOutputs(fluid('water') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//HIGH PURITY SILVER
BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustSilver') * 3) 
    .fluidInputs(fluid('nitric_acid') * 4000)
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('silver_nitrate_solution') * 2700)
    .fluidOutputs(fluid('nitric_oxide') * 1000)
    .duration(360)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .inputs(ore('plateSilver'))
    .fluidInputs(fluid('silver_nitrate_solution') * 250)
    .notConsumable(metaitem('plateStainlessSteel'))
    .notConsumable(fluid('silver_nitrate_solution') * 1000)
    .outputs(metaitem('dustHighPuritySilver'))
    .outputs(metaitem('silver_anode_slime'))
    .fluidOutputs(fluid('spent_moebius_electrolyte') * 250)
    .duration(480)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()
